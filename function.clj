(ns function)

(def human-consumption   [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])

(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(map unify-diet-data human-consumption critter-consumption)


(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))

(defn states
  [numbers]
  (map #(% numbers) [sum count avg]))

(states [3 4 10])

(def set-str #(str %))

(set-str 12)

(defn titleize
  [topic]
  (str topic " for the Brave and True"))

(map titleize ["Hamsters" "Ragnarok"])

(map titleize '("Empathy" "Decorating"))

(map titleize #{"Elbows" "Soap Carving"})

(map #(titleize (second %)) {:uncomfortable-thing "Winking"})

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max :min 10})


(assoc (assoc {} :max (inc 30))
       :min (inc 10))
