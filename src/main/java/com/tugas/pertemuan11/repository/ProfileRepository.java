package com.tugas.pertemuan11.repository;

import com.tugas.pertemuan11.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    boolean existsByNim(String nim);
}
