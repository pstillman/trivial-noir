(ns trivial-noir.db.mongo
  (:use somnium.congomongo)
  (:use [somnium.congomongo.config :only [*mongo-config*]]))

(defn maybe-init []
  "Checks if connection and collection exist, otherwise initialize."
  (when (not (connection? *mongo-config*))
    (let [config {:db "yoctoplasm_development"
                  :host "localhost"
                  :port "27017"}] 
      (mongo! :db (:db config) :host (:host config) :port (Integer. (:port config)))
      (if (not (or (nil? (:user config)) (nil? (:pass config))))
        (authenticate (:user config) (:pass config))))))

(defmacro with-db-conn [& body]
  `(do
    (maybe-init)
    ~@body))