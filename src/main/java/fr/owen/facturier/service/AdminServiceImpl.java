package fr.owen.facturier.service;

import fr.owen.facturier.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return adminRepository
                .findByMail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email" + email + " not found"));
    }
}
