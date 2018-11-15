package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegistracijaDTO;
import com.example.demo.model.Korisnik;
import com.example.demo.security.TokenUtils;
import com.example.demo.services.KorisnikServis;

public class KorisnikKontroler {
	
	@Autowired
	KorisnikServis korServis;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDTO) {
        try {
        	// Perform the authentication
        	UsernamePasswordAuthenticationToken token = 
        			new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);            
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload user details so we can generate token
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            String userToken = tokenUtils.generateToken(details);
            Korisnik kor = this.korServis.getUserByUsername(loginDTO.getUsername());
            
            LoginResponseDTO logRepDTO = new LoginResponseDTO(userToken, kor.getId(), loginDTO.getUsername(), 
            		kor.getKorisnikAuthorities().iterator().next().getAuthority().getNaziv());
            return new ResponseEntity<>(logRepDTO, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Logovanje nije uspelo", HttpStatus.BAD_REQUEST);
        }
	}
	
	@RequestMapping(value = "/api/registracija", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registracija(@RequestBody RegistracijaDTO regDTO)
    {
        LoginResponseDTO logRepDTO = this.korServis.registracija(regDTO);
        if(logRepDTO == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(regDTO, HttpStatus.CREATED);
    }

}
