package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch2Group2.BankUserManagement.model.BranchMaster;

@Repository
public interface BranchRepository extends JpaRepository<BranchMaster, String> {

}