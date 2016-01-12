package edu.waa.classified.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.waa.classified.model.CImage;

@Repository
public interface CImageRepository extends JpaRepository<CImage, Integer> {

}
