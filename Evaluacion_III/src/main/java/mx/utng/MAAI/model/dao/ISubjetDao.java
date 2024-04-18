package mx.utng.MAAI.model.dao;
import java.util.List;
import mx.utng.MAAI.model.entity.Subjet;

public interface ISubjetDao {
    List<Subjet> list();
  void save(Subjet subjet);
  Subjet getById(Long id);
  void delete(Long id);
}
