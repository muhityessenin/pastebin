package pet.project.pastebin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.pastebin.models.Paste;

import java.util.Optional;

public interface PasteRepository extends JpaRepository<Paste, Long> {
    Optional<Paste> findByUrl(String url);
}
