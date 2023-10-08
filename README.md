# NASA International SpaceApps Challenge 2023

We are enthusiastic participants in the NASA International SpaceApps Challenge of 2023, one of the biggest annual hackathons in the world.

## Code Overview

The provided Python script utilizes various libraries to assess the fire risk in a given location using NASA's FIRMS API within the context of our project theme: "Managing Fire: Increasing Community-based Fire Management Opportunities." Here's a breakdown:

1. **`requests` Library**
   - *Purpose*: Used for making HTTP requests.
   - *Relevance to Theme*: Enables communication with NASA's FIRMS API to obtain real-time fire data, supporting the goal of managing fires through data-driven insights.

2. **`geopy` Library**
   - *Components Used*: `distance`, `Point`
   - *Purpose*: Provides geocoding services and distance calculations.
   - *Relevance to Theme*: Used to calculate new geographical points and distances, contributing to community-based fire management by assessing risks in specific areas.

3. **`geocoder` Library**
   - *Purpose*: Geocoding library for obtaining location information based on IP addresses.
   - *Relevance to Theme*: Essential for community-based fire management by determining the current location of the user, allowing for localized risk assessments.

## Execution

When executed, the script follows these steps:

1. **Current Location Retrieval**:
   - Obtains the current location using the `getCurrentLocation` function, based on the user's IP address.

2. **Reference Points Calculation**:
   - Calculates two reference points (`point1` and `point2`) using the `getNewPoint` function, positioned at specific distances and directions from the center point.

3. **FIRMS API Request**:
   - Uses the `organize` function to format these points into a string suitable for an API request.
   - Sends a GET request to the FIRMS API using the `getFireData` function, retrieving fire data for the specified area and timeframe.

4. **Risk Assessment**:
   - Processes the retrieved fire data with the `getRiskPotential` function, assigning a priority level based on the risk indicated in the data.

5. **Printing Results**:
   - Prints the calculated risk level to the console.

# Objective Activation in Script

## Objective: Assess Fire Risk Locally

- **How it's Achieved:**
    - The `getCurrentLocation` function actively obtains the current location of the user based on their IP address, establishing a local context for the risk assessment.

## Objective: Fetch Real-Time Fire Data

- **How it's Achieved:**
    - The `getFireData` function actively sends a GET request to NASA's FIRMS API, fetching real-time fire data for a specific area based on the user's coordinates and range. This ensures that the risk assessment is based on the most recent information.

## Objective: Calculate Geographical Points

- **How it's Achieved:**
    - The `getNewPoint` function actively calculates two reference points (`point1` and `point2`) at specified distances and directions from the user's current location. This is crucial for defining the area of interest for fire risk assessment.

## Objective: Organize Data for API Request

- **How it's Achieved:**
    - The `organize` function actively formats the calculated points into a string suitable for an API request, ensuring that the FIRMS API receives the necessary information to provide relevant fire data.

## Objective: Evaluate Fire Risk Priority

- **How it's Achieved:**
    - The `getRiskPotential` function actively processes the retrieved fire data, assigning a priority level (low, medium, high) based on the assessed risk. This active evaluation is crucial for informing users about the level of danger in their local area.

## Objective: Present Results to the User

- **How it's Achieved:**
    - The script actively prints the calculated risk level to the console, providing a clear and immediate presentation of the fire risk to the user.

In summary, the objective of assessing fire risk within the context of community-based fire management is actively pursued through a systematic process of data retrieval, geospatial calculations, risk evaluation, and user communication. Each function and step in the script plays an active role in achieving this objective
