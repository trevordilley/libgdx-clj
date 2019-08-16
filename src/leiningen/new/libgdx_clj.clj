(ns leiningen.new.libgdx-clj
  (:require [leiningen.new.templates :refer [renderer raw-resourcer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :as str]
            [clojure.java.io :as io]))

(def render (renderer "libgdx-clj"))

(defn binary [file]
  (io/input-stream (io/resource (str/join "/" ["leiningen" "new" "libgdx_clj" file]))))


(defn libgdx-clj
  "Make a LibGDX game in Clojure!"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' libgdx-clj project.")
    (->files data
             ["desktop/src/{{sanitized}}/core/desktop_launcher.clj" (render "desktop_launcher.clj" data)]
             ["desktop/src-common/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["desktop/project.clj" (render "project.clj" data)]
             ["desktop/resources/badlogic.jpg" (binary "badlogic.jpg")]
             ["android/todo.txt" (render "todo.txt" data)]
             )))
