# 🔥 Fire Risk Assessment System  
**NASA International SpaceApps Challenge 2023**

Participação no **NASA SpaceApps Challenge 2023**, um dos maiores hackathons globais, com foco no tema:  
**“Managing Fire: Increasing Community-based Fire Management Opportunities”**.

Este projeto propõe uma solução para **avaliação de risco de incêndios em tempo real**, utilizando dados da API FIRMS da NASA combinados com geolocalização do usuário.

---

## 🎯 Objetivo

Desenvolver um sistema capaz de:

- Identificar a localização do usuário automaticamente  
- Coletar dados atualizados de incêndios via API da NASA  
- Analisar o risco de incêndio em uma região específica  
- Classificar o risco em níveis (baixo, médio, alto)  
- Exibir o resultado de forma simples e imediata  

---

## ⚙️ Tecnologias Utilizadas

- **Python**  
- **Requests** — consumo de APIs  
- **Geopy** — cálculos geoespaciais  
- **Geocoder** — obtenção de localização via IP  
- **NASA FIRMS API** — dados de incêndios em tempo real  

---

## 🧠 Visão Geral da Solução

O sistema realiza uma análise de risco baseada na localização do usuário, seguindo um fluxo estruturado:

1. Obtém a localização atual via IP  
2. Define uma área de análise ao redor do usuário  
3. Consulta dados de incêndio em tempo real  
4. Processa os dados coletados  
5. Classifica o nível de risco  
6. Retorna o resultado ao usuário  

---

## 🔄 Fluxo de Execução

### 📍 1. Obtenção da Localização
A função `getCurrentLocation` utiliza geolocalização por IP para identificar a posição atual do usuário, servindo como base para toda a análise.

---

### 🗺️ 2. Definição da Área de Análise
A função `getNewPoint` calcula pontos geográficos ao redor da localização central, criando uma área de interesse para consulta dos dados.

---

### 🔗 3. Integração com a API da NASA
A função `getFireData` realiza uma requisição HTTP para a **FIRMS API**, utilizando os pontos calculados para obter dados atualizados de incêndios.

---

### 🧾 4. Organização dos Dados
A função `organize` estrutura os dados geográficos no formato esperado pela API, garantindo uma requisição válida e eficiente.

---

### ⚠️ 5. Avaliação de Risco
A função `getRiskPotential` processa os dados retornados e classifica o risco com base na intensidade e proximidade dos focos de incêndio:

- **Baixo**  
- **Médio**  
- **Alto**  

---

### 📊 6. Exibição do Resultado
O sistema apresenta o nível de risco diretamente no console, de forma simples e objetiva.

---

## 🧩 Arquitetura e Abordagem

O projeto foi estruturado de forma modular, com separação clara de responsabilidades:

- **Geolocalização** → obtenção da posição do usuário  
- **Cálculo geoespacial** → definição da área de análise  
- **Integração externa** → consumo da API da NASA  
- **Processamento de dados** → análise e classificação de risco  
- **Saída** → comunicação do resultado  

Essa abordagem facilita manutenção, escalabilidade e futuras integrações (ex: interface web ou mobile).

---

## 🌍 Impacto

A solução contribui para:

- Monitoramento local de riscos ambientais  
- Apoio à tomada de decisão em comunidades  
- Uso de dados abertos para prevenção de incêndios  
- Conscientização sobre riscos em tempo real  

---

## 🚀 Possíveis Evoluções

- Interface web ou mobile  
- Sistema de alertas em tempo real  
- Histórico de risco por região  
- Integração com mapas interativos  
- Uso de machine learning para previsão de risco  

---

## 🏁 Conclusão

O projeto demonstra a aplicação prática de:

- Integração com APIs externas  
- Processamento de dados em tempo real  
- Geolocalização e cálculos geoespaciais  
- Estruturação modular de software  

Tudo isso voltado para um problema real, com potencial de impacto social.
