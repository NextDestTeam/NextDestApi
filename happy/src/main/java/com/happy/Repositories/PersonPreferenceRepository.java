package com.happy.Repositories;

import com.happy.Models.PersonPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPreferenceRepository extends JpaRepository<PersonPreference, Integer> {
}
