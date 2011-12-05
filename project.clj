(defproject trivial-noir "0.1.0-SNAPSHOT"
            :description "this is a very simple test of noir"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]
                           [congomongo "0.1.7"]]
            :dev-dependencies [[lein-ring "0.4.6"]]
            :ring {:handler trivial-noir.server/handler}
            :main trivial-noir.server)


