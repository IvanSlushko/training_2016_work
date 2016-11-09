CREATE TABLE "plane" (
	"id" serial NOT NULL,
	"bort_number" character varying NOT NULL UNIQUE,
	"model" character varying NOT NULL,
	"passenger_count" bigint NOT NULL,
	CONSTRAINT plane_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "flight" (
	"id" serial NOT NULL,
	"plane" bigint NOT NULL,
	"fromm" bigint NOT NULL,
	"d_and_t" DATE NOT NULL,
	"too" bigint NOT NULL,
	CONSTRAINT flight_pk PRIMARY KEY ("num")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "city" (
	"id" serial NOT NULL,
	"city" character varying NOT NULL,
	CONSTRAINT city_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "passenger" (
	"id" serial NOT NULL,
	"full_name" character varying NOT NULL,
	"birthday" DATE NOT NULL,
	"passport" character varying NOT NULL UNIQUE,
	CONSTRAINT passenger_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "ticket" (
	"id" serial NOT NULL,
	"fl_num" bigint NOT NULL,
	"passenger" bigint NOT NULL,
	"clas" bigint NOT NULL,
	"price" bigint NOT NULL,
	"bag" BOOLEAN NOT NULL,
	CONSTRAINT ticket_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "flight" ADD CONSTRAINT "flight_fk0" FOREIGN KEY ("plane") REFERENCES "plane"("id");
ALTER TABLE "flight" ADD CONSTRAINT "flight_fk1" FOREIGN KEY ("fromm") REFERENCES "city"("id");
ALTER TABLE "flight" ADD CONSTRAINT "flight_fk2" FOREIGN KEY ("too") REFERENCES "city"("id");



ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk0" FOREIGN KEY ("fl_num") REFERENCES "flight"("num");
ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk1" FOREIGN KEY ("passenger") REFERENCES "passenger"("id");

