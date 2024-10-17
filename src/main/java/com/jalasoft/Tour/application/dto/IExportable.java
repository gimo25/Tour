package com.jalasoft.Tour.application.dto;

import java.util.List;

/**
 * @author Giordano Bortolini
 */

public interface IExportable {

  List<String> createHeader();
  List<String> createRow();

}
