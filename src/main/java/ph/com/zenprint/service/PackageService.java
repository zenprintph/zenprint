package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.entity.Package;
import ph.com.zenprint.repository.PackageRepository;

/**
 * @author Choy
 * @date 11/3/2020.
 */

@RequiredArgsConstructor
@Service
public class PackageService {

    private final PackageRepository packageRepository;

    public void deliverPackage(Long packageId) {
        Package pkg = packageRepository.getOne(packageId);

        pkg.setQuantity(pkg.getQuantity() - 1);

        packageRepository.save(pkg);
    }
}