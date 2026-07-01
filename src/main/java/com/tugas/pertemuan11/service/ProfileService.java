package com.tugas.pertemuan11.service;

import com.tugas.pertemuan11.model.Profile;
import com.tugas.pertemuan11.model.User;
import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Profile saveProfile(String nama, String nim, String alamat, String jenisKelamin, User user);
}
