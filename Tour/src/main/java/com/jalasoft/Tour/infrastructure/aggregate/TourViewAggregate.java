package com.jalasoft.Tour.infrastructure.aggregate;

import com.jalasoft.Tour.application.dto.TourViewDto;
import com.jalasoft.Tour.domain.entity.TourImage;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Giordano Bortolini
 */
@Document(collection = "tour-image")
@Data
public class TourViewAggregate {

  @Id
  private String id;

  private String fileName;
  private byte[] data;

  public static TourViewAggregate fromDomain(TourImage tourImage) {

    TourViewAggregate image = new TourViewAggregate();
    image.setData(tourImage.getData());
    image.setFileName(tourImage.getFileName());
    return image;
  }

  public TourViewDto toDTO() {
    TourViewDto image = new TourViewDto();
    image.setData(data);
    image.setId(id);
    image.setFileName(fileName);
    return image;
  }
}
