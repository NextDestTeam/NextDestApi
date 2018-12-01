package com.happy.Repositories;

import com.happy.Models.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonTypeRepository extends JpaRepository<PersonType, Integer> {
}
