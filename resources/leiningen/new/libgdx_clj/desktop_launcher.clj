(ns {{sanitized}}.core.desktop-launcher
  (:require [{{sanitized}}.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main []
  (LwjglApplication. ({{sanitized}}.core.Game.) "{{name}}" 800 600)
  (Keyboard/enableRepeatEvents true))
