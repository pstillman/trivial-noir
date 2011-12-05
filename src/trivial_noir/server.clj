(ns trivial-noir.server
  (:require [noir.server :as server]))

(server/load-views "src/trivial_noir/views/")

(def handler (server/gen-handler {:mode :dev
                                  :ns 'trivial-noir}))

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8888"))]
    (server/start port {:mode mode
                        :ns 'trivial-noir})))
