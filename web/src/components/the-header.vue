<template>
    <a-layout-header class="header">
        <div class="logo" />
        <a-menu
                theme="dark"
                mode="horizontal"
                :style="{ lineHeight: '64px' }"
        >
            <a-menu-item key="/">
                <router-link to="/">Homepage</router-link>

            </a-menu-item>
            <a-menu-item key="/admin/ebook">
                <router-link to="/admin/ebook">Wiki management</router-link>

            </a-menu-item>
            <a-menu-item key="/admin/category">
                <router-link to="/admin/category">category management</router-link>

            </a-menu-item>
            <a-menu-item key="/about">
                <router-link to="/about">About Me</router-link>

            </a-menu-item>
        </a-menu>
    </a-layout-header>
</template>

<script lang="ts">
    import { defineComponent } from 'vue';

    export default defineComponent({
        name: 'the-header'
    });
</script>