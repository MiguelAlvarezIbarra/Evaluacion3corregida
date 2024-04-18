package mx.utng.MAAI.model.service;

import java.util.List;

import mx.utng.MAAI.model.entity.Subjet;

public interface ISubjetService {
    List<Subjet> list();
    void save(Subjet subjet);
    Subjet getByID(Long id);
    void delete(Long id);
}
