--ALTER TABLE public.city ADD COLUMN id integer;
--ALTER TABLE public.city ALTER COLUMN id SET NOT NULL;
--ALTER TABLE public.city ALTER COLUMN id SET DEFAULT nextval('city_id_seq'::regclass);


--ALTER TABLE public.plane ADD COLUMN id bigint;
--ALTER TABLE public.plane ALTER COLUMN id SET NOT NULL;
ALTER TABLE public.plane ALTER COLUMN id SET DEFAULT nextval('plane_id_seq'::regclass);