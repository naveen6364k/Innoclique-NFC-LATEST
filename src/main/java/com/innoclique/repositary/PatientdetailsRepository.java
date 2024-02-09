package com.innoclique.repositary;

import com.innoclique.entity.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Naveen Kumar Chintala
 */
@Repository
public interface PatientdetailsRepository extends JpaRepository<PatientDetails, Long>, JpaSpecificationExecutor<PatientDetails> {

}