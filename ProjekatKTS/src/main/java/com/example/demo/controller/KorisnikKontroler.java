package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KorisnikDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegistracijaDTO;
import com.example.demo.model.Korisnik;
import com.example.demo.security.TokenUtils;
import com.example.demo.services.KorisnikServis;

@RestController
@RequestMapping(value = "api/korisnik")
public class KorisnikKontroler {
	
	@Autowired
	KorisnikServis korServis;
	
	//@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDTO) {
        try {
        	// Perform the authentication
        	UsernamePasswordAuthenticationToken token = 
        			new UsernamePasswordAuthenticationToken(
					loginDTO.getEmail(), loginDTO.getLozinka());
            Authentication authentication = authenticationManager.authenticate(token);            
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload user details so we can generate token
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getEmail());
            String userToken = tokenUtils.generateToken(details);
            Korisnik kor = this.korServis.getUserByUsername(loginDTO.getEmail());
            
            LoginResponseDTO logRepDTO = new LoginResponseDTO(userToken, kor.getId(), loginDTO.getEmail(), 
            		kor.getKorisnikAuthorities().iterator().next().getAuthority().getNaziv());
            return new ResponseEntity<>(logRepDTO, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Logovanje nije uspelo", HttpStatus.BAD_REQUEST);
        }
	}
	
	@RequestMapping(value = "/registracija", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registracija(@RequestBody RegistracijaDTO regDTO)
    {
        LoginResponseDTO logRepDTO = this.korServis.registracija(regDTO);
        if(logRepDTO == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(regDTO, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/sviKorisnici", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> sviKorisnici()  {
        List<KorisnikDTO> korisniciDTO = this.korServis.sviKorisnici();
        if (korisniciDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable Long id) {
		Korisnik kor = korServis.getUserById(id);
		if (kor == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new KorisnikDTO(kor), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{email}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnikByEmail(@PathVariable String email) {
		Korisnik kor = korServis.getUserByUsername(email);
		if (kor == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new KorisnikDTO(kor), HttpStatus.OK);
	}

}
