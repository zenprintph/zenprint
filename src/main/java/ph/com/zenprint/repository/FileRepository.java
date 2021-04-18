package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.SysFile;

/**
 * @author Choy
 * @date 12/27/2020.
 */

@Repository
public interface FileRepository extends JpaRepository<SysFile, Long> {
}
