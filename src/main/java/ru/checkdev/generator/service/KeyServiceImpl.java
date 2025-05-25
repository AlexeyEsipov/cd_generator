package ru.checkdev.generator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.checkdev.generator.domain.Key;
import ru.checkdev.generator.repository.KeyRepository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class KeyServiceImpl implements KeyService {
    private final KeyRepository repository;

    @Override
    public List<Key> getKeysForExam(String text) {
        Set<Key> keySet = new LinkedHashSet<>();
        List<Key> keyList = repository.findAll();
        for (Key element : keyList) {
            if (text.contains(element.getName())) {
                keySet.add(element);
            }
        }
        return new  ArrayList<>(keySet);
    }
}
