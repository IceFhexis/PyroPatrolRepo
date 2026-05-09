# 🔥 Fire Risk API

API REST desenvolvida com **Spring Boot** para análise de risco de incêndios em tempo real, utilizando dados da **NASA FIRMS API**.

---

## 📌 Sobre o Projeto

O objetivo deste projeto é avaliar o risco de incêndio em uma determinada localização geográfica com base em dados reais fornecidos pela NASA.

A aplicação calcula automaticamente uma área ao redor do usuário, consulta eventos de incêndio recentes e classifica o risco em:

* 🟢 Low (baixo)
* 🟡 Medium (médio)
* 🔴 High (alto)

---

## 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot 3
* Spring Security (JWT)
* OpenFeign (integração com API externa)
* Maven
* NASA FIRMS API

---

## 🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

```
controller → service → client → util
            ↓
           dto ↔ mapper ↔ model
```

### 📂 Estrutura

```
controller/     → endpoints da API
service/        → regras de negócio
client/         → integração com NASA
dto/            → dados de saída (record)
mapper/         → conversão de objetos
model/          → representação interna
util/           → lógica auxiliar (geo + análise)
security/       → autenticação JWT
```

---

## 🔐 Autenticação

A API utiliza **JWT (JSON Web Token)**.

### 🔑 Gerar token

```http
POST /auth/login?username=daniel
```

Resposta:

```
token JWT
```

---

## 📡 Endpoints

### 🔥 Obter risco automático

```http
GET /api/v1/risk
Authorization: Bearer TOKEN
```

---

### 📍 Obter risco por coordenadas

```http
GET /api/v1/risk/custom?lat=-22.9&lon=-43.2
Authorization: Bearer TOKEN
```

---

## ⚙️ Configuração

### 1️⃣ Clonar o projeto

```bash
git clone https://github.com/seuusuario/fire-risk-api.git
cd fire-risk-api
```

---

### 2️⃣ Configurar API da NASA

Edite o arquivo:

```yaml
application.yml
```

```yaml
nasa:
  api-key: SUA_API_KEY
```

🔗 Obtenha sua chave em:
https://firms.modaps.eosdis.nasa.gov/api/

---

### 3️⃣ Rodar o projeto

```bash
mvn spring-boot:run
```

ou

```bash
./mvnw spring-boot:run
```

---

## 🧠 Como funciona

1. Obtém a localização (ou usa coordenadas informadas)
2. Calcula dois pontos geográficos formando uma área
3. Consulta a API da NASA FIRMS
4. Processa os dados retornados (CSV)
5. Classifica o nível de risco
6. Retorna o resultado em JSON

---

## 📊 Exemplo de resposta

```json
{
  "latitude": -22.9,
  "longitude": -43.2,
  "risk": "medium"
}
```
---

## Disclaimer !
Este projeto pode apresentar falhas!!!

---

## 👨‍💻 Autor

**Daniel José Figueiredo de Santana**

* LinkedIn: https://linkedin.com/in/daniel-josé-figueiredo-de-santana-508281275

---

## 📄 Licença

Este projeto é de uso educacional e demonstração técnica.
