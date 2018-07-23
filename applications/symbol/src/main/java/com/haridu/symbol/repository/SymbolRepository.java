package com.haridu.symbol.repository;

import com.haridu.symbol.entity.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    Symbol findBySymbol(@Param("symbol") String symbol);
}
