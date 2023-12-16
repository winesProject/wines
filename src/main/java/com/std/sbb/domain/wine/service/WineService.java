package com.std.sbb.domain.wine.service;

import com.std.sbb.domain.taste.entity.Taste;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;

    public void create(String wineName, String country, String list, Integer price, String kind, String food, byte[] image, Taste taste) {
        String imagePath = saveImageToFileSystem(image);

        Wine wine = new Wine();
        wine.setWineName(wineName);
        wine.setCountry(country);
        wine.setList(list);
        wine.setPrice(price);
        wine.setKind(kind);
        wine.setFood(food);
        wine.setImage(imagePath);
        wine.setTaste(taste);
        this.wineRepository.save(wine);
    }
    private String saveImageToFileSystem(byte[] image) {
        // 이미지를 파일로 저장하고 파일 경로를 반환하는 로직을 구현
        // 예를 들어, UUID를 사용하여 파일명을 생성하고 파일 시스템에 저장
        // 경로는 프로젝트나 외부 디렉토리에 저장 가능
        String fileName = UUID.randomUUID().toString() + ".jpg";
        String filePath = "/path/to/save/images/" + fileName;

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image to file system", e);
        }

        return filePath;
    }
}