insert into TOUR_PACKAGE (code, start_date, end_date,name,price)
  values ('TC1','23-AUG-24','24-NOV-24', 'Travel to Colombia', 1500);
insert into TOUR_PACKAGE (code, start_date, end_date,name,price)
  values ('TB1','23-AUG-24','24-NOV-24', 'Travel to Bolivia', 2300);
insert into TOUR_PACKAGE (code, start_date, end_date,name,price)
  values ('TM1','23-AUG-24','24-NOV-24', 'Travel to Mexico',3100);

insert into TOUR (id, description,duration,title,price,nice_place,code)
  values ('dd390c86-336c-45ff-886e-dbd92962729e', 'Visit The Cristo de la Concordia','4h','Bolivia',300, true, 'TB1');
insert into TOUR (id, description,duration,title,price,nice_place,code)
  values ('dd390c86-336c-45ff-886e-dbd92962722e', 'Dolphins SPA','4h','Bolivia',200, true, 'TB1');
insert into TOUR (id, description,duration,title,price,nice_place,code)
  values ('dd390c86-336c-45ff-886e-dbd92962429e', 'Visit riviera maya','2d','Mexico',300, true, 'TM1');
insert into TOUR (id, description,duration,title,price,nice_place,code)
  values ('dd390c86-336c-45ff-886e-dbd92965529e', 'Xcaret','3d','Mexico',500, true,'TM1');
insert into TOUR (id, description,duration,title,price,nice_place,code)
  values ('dd390c86-336c-45ff-886e-dbd92961129e', 'Visit Cartagena','6d','Colombia',700, true, 'TC1');
