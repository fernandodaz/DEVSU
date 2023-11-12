--
-- PostgreSQL database dump
--

-- Dumped from database version 15.5 (Ubuntu 15.5-1.pgdg22.04+1)
-- Dumped by pg_dump version 16.1 (Ubuntu 16.1-1.pgdg22.04+1)

-- Started on 2023-11-12 03:42:18 -04

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
-- TOC entry 214 (class 1259 OID 105520)
-- Name: client_seq; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE public.client_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_seq OWNER TO fernando;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 105543)
-- Name: cliente; Type: TABLE; Schema: public; Owner: fernando
--

CREATE TABLE public.cliente (
    status boolean,
    client_id bigint NOT NULL,
    person_id bigint,
    password character varying(255)
);


ALTER TABLE public.cliente OWNER TO fernando;

--
-- TOC entry 216 (class 1259 OID 105541)
-- Name: cliente_seq; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE public.cliente_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cliente_seq OWNER TO fernando;

--
-- TOC entry 222 (class 1259 OID 106213)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: fernando
--

CREATE TABLE public.cuenta (
    estado boolean,
    saldo_inicial double precision,
    id bigint NOT NULL,
    numero_cuenta character varying(255),
    tipo_cuenta character varying(255),
    cliente bytea
);


ALTER TABLE public.cuenta OWNER TO fernando;

--
-- TOC entry 220 (class 1259 OID 106211)
-- Name: cuenta_seq; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE public.cuenta_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cuenta_seq OWNER TO fernando;

--
-- TOC entry 223 (class 1259 OID 106220)
-- Name: movimientos; Type: TABLE; Schema: public; Owner: fernando
--

CREATE TABLE public.movimientos (
    fecha date,
    saldo double precision,
    valor double precision,
    id bigint NOT NULL,
    numero_cuenta_id bigint,
    movimiento character varying(255),
    tipo character varying(255)
);


ALTER TABLE public.movimientos OWNER TO fernando;

--
-- TOC entry 221 (class 1259 OID 106212)
-- Name: movimientos_seq; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE public.movimientos_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.movimientos_seq OWNER TO fernando;

--
-- TOC entry 215 (class 1259 OID 105521)
-- Name: person_seq; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE public.person_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.person_seq OWNER TO fernando;

--
-- TOC entry 219 (class 1259 OID 105550)
-- Name: persona; Type: TABLE; Schema: public; Owner: fernando
--

CREATE TABLE public.persona (
    age integer,
    id bigint NOT NULL,
    address character varying(255),
    gender character varying(255),
    identification character varying(255),
    name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.persona OWNER TO fernando;

--
-- TOC entry 217 (class 1259 OID 105542)
-- Name: persona_seq; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE public.persona_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.persona_seq OWNER TO fernando;

--
-- TOC entry 3234 (class 2606 OID 105549)
-- Name: cliente cliente_person_id_key; Type: CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_person_id_key UNIQUE (person_id);


--
-- TOC entry 3236 (class 2606 OID 105547)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (client_id);


--
-- TOC entry 3240 (class 2606 OID 106219)
-- Name: cuenta cuenta_pkey; Type: CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id);


--
-- TOC entry 3242 (class 2606 OID 106226)
-- Name: movimientos movimientos_pkey; Type: CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (id);


--
-- TOC entry 3238 (class 2606 OID 105556)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 3244 (class 2606 OID 106227)
-- Name: movimientos fkdcgdi5tx1vkc6tl3q3dj1j4vm; Type: FK CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT fkdcgdi5tx1vkc6tl3q3dj1j4vm FOREIGN KEY (numero_cuenta_id) REFERENCES public.cuenta(id);


--
-- TOC entry 3243 (class 2606 OID 105557)
-- Name: cliente fkq9bj6hqnrc47rcv0b0hdvldrf; Type: FK CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fkq9bj6hqnrc47rcv0b0hdvldrf FOREIGN KEY (person_id) REFERENCES public.persona(id);


-- Completed on 2023-11-12 03:42:18 -04

--
-- PostgreSQL database dump complete
--

