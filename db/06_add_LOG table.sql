-- Table: public.log_info

-- DROP TABLE public.log_info;

CREATE TABLE public.logs
(
  date time without time zone,
  level character varying,
  logger character varying,
  message character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.logs
  OWNER TO postgres;