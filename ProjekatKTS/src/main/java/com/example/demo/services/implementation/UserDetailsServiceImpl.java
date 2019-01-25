package com.example.demo.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Korisnik;
import com.example.demo.repositories.KorisnikRepozitorijum;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private KorisnikRepozitorijum korRep;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik kor = korRep.findByUsername(username);
		if (kor == null)
		      throw new UsernameNotFoundException(String.format("Ne postoji korisnik sa email adresom '%s'.", username));
		else {
			List<GrantedAuthority> grantedAuthorities = kor.getKorisnikAuthorities().stream()
	                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority().getNaziv()))
	                .collect(Collectors.toList());
	    	return new org.springframework.security.core.userdetails.User(
	    		  kor.getEmail(),
	    		  kor.getLozinka(),
	    		  grantedAuthorities);
		}
	}

}
