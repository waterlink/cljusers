(ns cljusers.endpoint.status
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [ring.middleware.json :refer [wrap-json-response]]))

(defn status-endpoint [{{db :spec} :db}]
  (wrap-json-response
   (routes
    (GET "/" [] {:body {:status "ok"}}))))
