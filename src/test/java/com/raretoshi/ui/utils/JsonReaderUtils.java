package com.raretoshi.ui.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonReaderUtils {

  public static Map<String, String> config = new HashMap<>();

  public static String getValueByKey(String key) {
    return config.get(key);
  }

  public static void fileToMapConfig() {
    File file = new File("src/test/resources/config_browser.json");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      config = objectMapper.readValue(file, new TypeReference<>() {
      });
    } catch (IOException e) {
      LogUtils.error("Missing file OR Incorrect file path: src/test/resources/config_browser.json");
      throw new RuntimeException(e);
    }
  }
}
