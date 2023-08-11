--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: heroes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.heroes (
    heroid integer NOT NULL,
    heroname character varying,
    age integer,
    specialpower character varying,
    weakness character varying,
    squad character varying,
    deleted boolean DEFAULT false
);


ALTER TABLE public.heroes OWNER TO postgres;

--
-- Name: heroes_heroid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.heroes_heroid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.heroes_heroid_seq OWNER TO postgres;

--
-- Name: heroes_heroid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.heroes_heroid_seq OWNED BY public.heroes.heroid;


--
-- Name: squads; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.squads (
    squadid integer NOT NULL,
    squad character varying,
    size integer DEFAULT 5,
    cause character varying,
    deleted boolean DEFAULT false
);


ALTER TABLE public.squads OWNER TO postgres;

--
-- Name: squads_squadid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.squads_squadid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.squads_squadid_seq OWNER TO postgres;

--
-- Name: squads_squadid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.squads_squadid_seq OWNED BY public.squads.squadid;


--
-- Name: heroes heroid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.heroes ALTER COLUMN heroid SET DEFAULT nextval('public.heroes_heroid_seq'::regclass);


--
-- Name: squads squadid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.squads ALTER COLUMN squadid SET DEFAULT nextval('public.squads_squadid_seq'::regclass);


--
-- Data for Name: heroes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.heroes (heroid, heroname, age, specialpower, weakness, squad, deleted) FROM stdin;
14	ISAAC MENDEZ	26	 Precognitive	Forced  to return to normal quickly 	WHITE SHARKS RANGERS	t
29	Zeus Bingo	25	Smarter	Fighter	\N	t
16	GABRIEL GRAY	27	Innate ability 	 Frequent burn outs 	\N	t
5	Zeus	25	Thriller	Runner	\N	t
2	David Emerald	12	Thriller	Sanity	\N	t
1	LeeShan	25	Indomitable	Runner	GIGANTIC	t
22	Gaelins	20	Starling	Silent	\N	t
17	NIKI SANDERS	35	Super-strength and durability	Incapable of maintaining a proper physical form	\N	t
18	PETER PETRELLI	30	Telepathy	Loses his immense powers	\N	t
3	Mary	34	Getter	Silent	\N	t
4	Getter	23	Indomitable	Senseless	\N	t
8	KarlHans	14	Indomitable	Runner	GIGANTIC	t
9	David	23	Thriller	Sanity	THE KUDOS SEEKERS	t
20	DAVINCI	25	Agile	Sanity	GIGANTIC	t
25	KarlHans Nd	24	Indomitable	Silent	\N	t
23	ShanayaPro	20	Game changer	Flier	GIGANTIC	t
39	Jemedal	25	Thriller	Sanity	\N	t
40	Gabriel	25	Thriller	Sanity	\N	t
41	Jesus	25	Starling	Sanity	\N	t
15	NATHAN PETRELLI	24	incredible speeds	Unable to use her magic	GIGANTIC	t
42	MSOO	25	Thriller	Runner	GIGANTIC	f
43	NDUNGU	30	Indomitable	Senseless	GIGANTIC	f
49	124	12	Thriller	2222	\N	t
45	KIMONDIO	25	Smarter	Sanity	FLASHERS	f
44	SILAS	35	Agile	Fighter	PURRFECT FRIENDS	t
46	MUTONYI	29	Getter	Loses his immense powers	THE KUDOS SEEKERS	t
24	Liam Gwiji	23	Fast and Furious	Loses magical powers	THE KUDOS SEEKERS	t
32	LiamBA	23	Thriller	Sanity	\N	t
27	DM Emerald	30	Thriller	Sanity	CHARLIES ANGELS	t
50	MERIBONE	35	Smarter	Runner	THE KUDOS SEEKERS	f
33	Mary Mso	24	Strong	Sleepy	\N	t
34	MaryMso	25	Starling	Sleepy	\N	t
35	Mso	25	Smarter	Sleepy	\N	t
36	Msoo	25	Thriller	Silent	\N	t
37	MsoMary	27	Indomitable	Sanity	\N	t
13	CLAIRE BENNET	25	 Regeneration  	vulnerable to raw, unprocessed materials	CHARLIES ANGELS	t
19	MATT PARKMAN	25	Teleport	Susceptible to performance                 	SERIALIZER	t
52	LEESHAN	70	Smarter	Sleepy	PURRFECT FRIENDS	f
48	BRIAN	25	Indomitable	Silent	THE KUDOS SEEKERS	f
47	WILSON	25	Indomitable	Sanity	THE KUDOS SEEKERS	f
\.


--
-- Data for Name: squads; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.squads (squadid, squad, size, cause, deleted) FROM stdin;
1	GIGANTIC	3	Veteran	f
2	PURRFECT FRIENDS	2	Furious rangers	f
3	THE KUDOS SEEKERS	3	Snippers	f
5	FLASHERS	1	2	f
\.


--
-- Name: heroes_heroid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.heroes_heroid_seq', 52, true);


--
-- Name: squads_squadid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.squads_squadid_seq', 5, true);


--
-- Name: heroes heroes_heroname_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.heroes
    ADD CONSTRAINT heroes_heroname_key UNIQUE (heroname);


--
-- Name: squads squads_squad_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.squads
    ADD CONSTRAINT squads_squad_key UNIQUE (squad);


--
-- PostgreSQL database dump complete
--

