-- Table: public.log_info

-- DROP TABLE public.log_info;

CREATE TABLE public.log_info
(
  user_id character varying(30),
  date date,
  level character varying(60),
  logger character varying(10),
  message character varying(1000)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.log_info
  OWNER TO postgres;
