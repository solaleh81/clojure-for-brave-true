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

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1
         :critter 3.9})


(defn fibo [n]
  (condp = n
    0 0
    1 1
    (+ (fibo (- n 1)) (fibo (- n 2)))))

(fibo 12)

(take 3 [1 2 3 4 5 6 7 8 9])

(drop 3 [1 2 3 4 5 6 7 8 9])

(def food-journal
  [
   {:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}
  ]
  )

(take-while #(< (:month %) 3) food-journal)

(drop-while #(< (:month %) 3) food-journal)

(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))

(assoc (assoc {} :max (inc 30))
       :min (inc 10))

(def create-map #(assoc {} % (inc 12)))

(map #(% [:firstname :lastname]) [create-map])

(filter #(< (:human %) 5) food-journal)

(some #(> (:critter %) 5) food-journal)

(some #(> (:critter %) 3) food-journal)

(some #(and (> (:critter %) 3) %) food-journal)

(sort [3 1 2])

(sort-by count ["aaa" "c" "bb"])

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true :name "McMackson"}
   2 {:makes-blood-puns? true, :has-pulse? false :name "Damon Salvator"}
   3 {:makes-blood-puns? true}, :has-pulse? true :name "Mickey Mouse"})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn indentify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))


(time (vampire-related-details 3))

(time (vampire-related-details 0))

(concat (take 8 (repeat "na")) ["Batman"])

(take 3 (repeatedly (fn [] (rand-int 10))))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))

(cons 0 '(2 3 4))

(empty? [])

(empty? ["no"])

(map identity {:sunlight-reaction "Glitter"})

(into {} (map identity {:sunlight-reaction "Glitter"}))

(into [] (map identity [:garlic :sesame-oil :fried-eggs]))

(into #{} (map identity [:garlic-clove :garlic-clove]))

(into {:favorite-emotion "gloomy"} [[:sunlight-reaction "Glitter!"]])

(into ["cherry"] '("pine" "spurce"))

(conj [0] [1])

(defn my-conj
  [target & additions]
  (into target additions))

(my-conj [0] 1 2 3)

(max 0 1 2)

(apply max [1 2 3])

(defn my-into
  [target additions]
  (apply conj target additions))

(my-into [0] [1 2 3])

(def add10 (partial + 10))

(add10 3)

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "unobtaininum" "adamantium")

(defn mapify
  "Return a seq of maps like {:name 'edward cullen' :glitter-index 12}")
