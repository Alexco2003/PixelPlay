<script setup lang="ts">
const props = defineProps<{
  title: string,
  imgSrc: string,
  linkPvp: string
  linkAi: string,
}>();

const emits = defineEmits<{
  (e: 'showChoice', payload: {
    gameTitle: string,
    linkToPVP: string,
    linkToAI: string
  }) : void
}>()
</script>

<template>
  <div @click="emits('showChoice', {gameTitle: title, linkToPVP: linkPvp, linkToAI: linkAi})"
       id="container" class="w-[400px] h-[265px] lg:w-[450px] lg:h-[300px] rounded-lg bg-purple-600 relative hover:cursor-pointer">
    <img :src="props.imgSrc" :alt="props.title"
         class="w-full h-full object-cover rounded-lg"  />

    <div id="overlay" class="w-full h-full bg-emerald-400 absolute bottom-0 left-0 rounded-lg"/>

    <div id="text" class="absolute bottom-0 left-0 p-4 text-lg font-bold">
      {{ props.title }}
    </div>
  </div>
</template>

<style>
#overlay {
  opacity: 0;
  transition: opacity 0.3s ease-in-out;
}

#text {
  opacity: 0;
  transition: opacity 0.3s ease-in-out;
}

#container:hover > #text {
  opacity: 1;
}

#container:hover > #overlay {
  opacity: 0.3;
}
</style>