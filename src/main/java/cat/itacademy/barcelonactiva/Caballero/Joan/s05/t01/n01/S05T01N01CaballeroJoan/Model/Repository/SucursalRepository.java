package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Repository;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
