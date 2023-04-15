package org.jsp.supermarket.repository;

import org.jsp.supermarket.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, String> {

}
