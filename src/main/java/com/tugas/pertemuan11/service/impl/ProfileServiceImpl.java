package com.tugas.pertemuan11.service.impl;

import com.tugas.pertemuan11.model.Profile;
import com.tugas.pertemuan11.model.User;
import com.tugas.pertemuan11.repository.ProfileRepository;
import com.tugas.pertemuan11.service.ProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile saveProfile(String nama, String nim, String alamat, String jenisKelamin, User user) {
        if (profileRepository.existsByNim(nim)) {
            throw new IllegalArgumentException("NIM sudah terdaftar");
        }
        return profileRepository.save(new Profile(nama, nim, alamat, jenisKelamin, user));
    }
}
