# Fawry
# 🚗 Car Factory System

A simple Java project demonstrating Object-Oriented Programming (OOP) concepts through a car factory system with interchangeable engines.

---

## 📌 Overview

This project simulates a car that can operate with different types of engines.
It also allows dynamic engine replacement using a factory design approach.

The system focuses on clean design and core OOP principles.

---

## 🧠 Concepts Used

* Inheritance
* Polymorphism
* Composition
* Abstraction

---

## ⚙️ Features

### 🚘 Car Capabilities

* Start the car at speed 0
* Stop the car safely
* Accelerate (+20 km/h up to 200 km/h)
* Brake (-20 km/h)
* Automatically sync engine speed with car speed

---

### 🔧 Engine Types

| Engine Type       | Description             |
| ----------------- | ----------------------- |
| GasolineEngine    | Traditional fuel engine |
| ElectronicEngine  | Electric-powered engine |
| MixedHybridEngine | Smart hybrid engine     |

---

### 🔋 Hybrid Engine Logic

* Uses **Electric Engine** when speed < 50 km/h
* Uses **Gasoline Engine** when speed ≥ 50 km/h
* Never runs both engines simultaneously (cost optimization)

---

## 🏭 Car Factory

The factory is responsible for:

* Creating cars with a selected engine type
* Replacing engines for existing cars

---

## 🧩 Project Structure

```id="6knyu3"
Engine (abstract)
├── GasolineEngine
├── ElectronicEngine
└── MixedHybridEngine

Car
CarFactory
Main
```

---

## ▶️ Example

```java id="dp46k1"
Car car = CarFactory.createCar("gas");

car.start();
car.accelerate();
car.brake();

car.setEngine(new MixedHybridEngine());
car.accelerate();
```

---

## 🚀 How to Run

1. Clone the repository
2. Open in any Java IDE (IntelliJ, Eclipse, VS Code)
3. Run the `Main` class

---

## 💡 Notes

* Engine internal logic is simplified
* Focus is on system design, not real-world physics
* Easy to extend with new engine types

---

## 🎯 Purpose

This project is built for learning and practicing OOP design in Java in a simple and practical way.

