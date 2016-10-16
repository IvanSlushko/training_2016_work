CREATE TABLE "plane" (
	"bort_number" serial(255) NOT NULL UNIQUE,
	"model" VARCHAR(255) NOT NULL,
	"resource" integer NOT NULL,
	CONSTRAINT plane_pk PRIMARY KEY ("bort_number")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "flight" (
	"num" serial NOT NULL,
	"plane" VARCHAR(255) NOT NULL,
	"from" integer NOT NULL,
	"d_and_t" DATETIME NOT NULL,
	"to" integer NOT NULL,
	CONSTRAINT flight_pk PRIMARY KEY ("num")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "ticket" (
	"id" serial NOT NULL,
	"fl_num" integer NOT NULL,
	"passenger" integer NOT NULL,
	"class" integer NOT NULL,
	"price" integer NOT NULL,
	"bag" BOOLEAN NOT NULL,
	CONSTRAINT ticket_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "passengers" (
	"id" serial NOT NULL,
	"full_name" VARCHAR(255) NOT NULL,
	"birthday" DATE NOT NULL,
	"passport" VARCHAR(255) NOT NULL UNIQUE,
	CONSTRAINT passengers_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "reservation" (
	"fl_num" integer NOT NULL,
	"ticked_id" integer NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "cities" (
	"id" serial NOT NULL,
	"city" serial(255) NOT NULL,
	CONSTRAINT cities_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "schedule" (

) WITH (
  OIDS=FALSE
);




ALTER TABLE "flight" ADD CONSTRAINT "flight_fk0" FOREIGN KEY ("plane") REFERENCES "plane"("bort_number");
ALTER TABLE "flight" ADD CONSTRAINT "flight_fk1" FOREIGN KEY ("from") REFERENCES "cities"("id");
ALTER TABLE "flight" ADD CONSTRAINT "flight_fk2" FOREIGN KEY ("to") REFERENCES "cities"("id");

ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk0" FOREIGN KEY ("fl_num") REFERENCES "flight"("num");
ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk1" FOREIGN KEY ("passenger") REFERENCES "passengers"("id");


ALTER TABLE "reservation" ADD CONSTRAINT "reservation_fk0" FOREIGN KEY ("fl_num") REFERENCES "flight"("num");
ALTER TABLE "reservation" ADD CONSTRAINT "reservation_fk1" FOREIGN KEY ("ticked_id") REFERENCES "ticket"("id");



