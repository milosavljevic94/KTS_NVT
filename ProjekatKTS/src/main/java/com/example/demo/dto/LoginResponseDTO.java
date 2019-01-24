package com.example.demo.dto;

import com.example.demo.model.Korisnik;

public class LoginResponseDTO {

	private String token;
    private Long id;
    private String email;
    private String tip;
    
    public LoginResponseDTO() {};
    
    public LoginResponseDTO(String token, Long id, String email, String tip) {
		super();
		this.token = token;
		this.id = id;
		this.email = email;
		this.tip = tip;
	}

	public LoginResponseDTO(Korisnik kor)
    {
        this.token = kor.getLozinka();
        this.id = kor.getId();
        this.email = kor.getEmail();
        //this.tip = kor.getPrviKorisnikAuthority().getAuthority().getNaziv();
        this.tip = "GRADJANIN";
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
