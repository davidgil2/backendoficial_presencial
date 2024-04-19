package co.udea.airline.api.model.jpa.repository.security;

import co.udea.airline.api.model.jpa.model.security.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {


    @Query("""
select t from Token t inner join Person u on t.person.personId = u.personId
where t.person.personId = :userId and t.loggedOut = false
""")
    List<Token> findAllTokensByUser(Integer userId);

    Optional<Token> findByToken(String token);
}
