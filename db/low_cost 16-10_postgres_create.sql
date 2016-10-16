CREATE TABLE "plane" (
	"bort_number" character varying NOT NULL UNIQUE,
	"model" character varying NOT NULL,
	"resource" bigint NOT NULL,
	CONSTRAINT plane_pk PRIMARY KEY ("bort_number")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "reservation" (
	"fl_num" bigint NOT NULL,
	"ticked_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "flight" (
	"num" bigint NOT NULL,
	"plane" character varying NOT NULL,
	"from" bigint NOT NULL,
	"d_and_t" DATE NOT NULL,
	"to" bigint NOT NULL,
	CONSTRAINT flight_pk PRIMARY KEY ("num")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "shedule" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "cities" (
	"id" serial NOT NULL,
	"city" character varying NOT NULL,
	CONSTRAINT cities_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "passengers" (
	"id" serial NOT NULL,
	"full_name" character varying NOT NULL,
	"birthday" DATE NOT NULL,
	"passport" character varying NOT NULL UNIQUE,
	CONSTRAINT passengers_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "ticket" (
	"id" serial NOT NULL,
	"fl_num" bigint NOT NULL,
	"passenger" bigint NOT NULL,
	"class" bigint NOT NULL,
	"price" bigint NOT NULL,
	"bag" BOOLEAN NOT NULL,
	CONSTRAINT ticket_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "reservation" ADD CONSTRAINT "reservation_fk0" FOREIGN KEY ("fl_num") REFERENCES "flight"("num");
ALTER TABLE "reservation" ADD CONSTRAINT "reservation_fk1" FOREIGN KEY ("ticked_id") REFERENCES "ticket"("id");

ALTER TABLE "flight" ADD CONSTRAINT "flight_fk0" FOREIGN KEY ("plane") REFERENCES "plane"("bort_number");
ALTER TABLE "flight" ADD CONSTRAINT "flight_fk1" FOREIGN KEY ("from") REFERENCES "cities"("id");
ALTER TABLE "flight" ADD CONSTRAINT "flight_fk2" FOREIGN KEY ("to") REFERENCES "cities"("id");




ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk0" FOREIGN KEY ("fl_num") REFERENCES "flight"("num");
ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk1" FOREIGN KEY ("passenger") REFERENCES "passengers"("id");

