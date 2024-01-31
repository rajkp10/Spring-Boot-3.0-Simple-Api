package com.practiceproject1.simpleapi.laptop;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaptopRepository extends JpaRepository<Laptop, UUID> {
}
