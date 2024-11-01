
package com.jalasoft.Tour.application.utils;

import com.jalasoft.Tour.application.dto.IExportable;
import com.jalasoft.Tour.application.dto.StreamOutput;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import lombok.AllArgsConstructor;
import com.opencsv.CSVWriter;

/**
 * @author Giordano Bortolini
 */
@AllArgsConstructor
public class CSVStreamingOutput<DTO extends IExportable> implements StreamOutput {

  private final List<DTO> exportableData;

  @Override
  public void write(final OutputStream output) {

    try (OutputStreamWriter stream = new OutputStreamWriter(output);
        BufferedWriter bufferedWriter = new BufferedWriter(stream);
        CSVWriter csvWriter = new CSVWriter(bufferedWriter)) {
      csvWriter.writeNext(exportableData.getFirst().createHeader().toArray(new String[0]), false);
      for (DTO data : exportableData) {
        csvWriter.writeNext(data.createRow().toArray(new String[0]), false);
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
