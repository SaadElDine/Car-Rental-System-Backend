package com.example.carrentbe.serviceImplementation;

import com.example.carrentbe.model.Admin;
import com.example.carrentbe.repository.AdminRepository;
import com.example.carrentbe.service.AdminService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, BCryptPasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public Admin getAdminById(Long id) {
        // Retrieve an admin by ID and clear the password before returning
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setPassword(null);
                    return admin;
                })
                .orElse(null); // Return null or throw a custom exception if the admin is not found
    }



    @Override
    public void deleteAdmin(Long id) {
        // Delete the admin if it exists
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        } else {
            // Handle the case where the admin doesn't exist or log this event
        }
    }

    @Override
    public boolean checkAdminCredentials(String email, String rawPassword) {
        // Check the admin's credentials
        System.out.println("Email: " + email + " Password: " + rawPassword);
        System.out.println("elzeft ::");
        System.out.println(adminRepository.findByEmail(email));
        System.out.println(adminRepository.findByEmail(email).map(admin -> passwordEncoder.matches(rawPassword, admin.getPassword())));
        return adminRepository.findByEmail(email)
                .map(admin -> passwordEncoder.matches(rawPassword, admin.getPassword()))
                .orElse(false); // Return false if the admin is not found or if the password doesn't match
    }

    @Override
    public Admin changeAdminPassword(Long id, String newPassword) {
        // Find the admin and change the password
        return adminRepository.findById(id)
                .map(admin -> {
                    String encryptedPassword = passwordEncoder.encode(newPassword);
                    admin.setPassword(encryptedPassword);
                    return adminRepository.save(admin);
                })
                .orElse(null); // Handle the case where the admin doesn't exist
    }

    @Override
    public Admin getAdminByEmail(String email) {
        // Retrieve an admin by email
        return adminRepository.findByEmail(email).orElse(null);
    }

    // Additional methods and business logic...
}
