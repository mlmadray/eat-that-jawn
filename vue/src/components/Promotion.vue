<script>
export default {
  name: "modal",
  data() {
    return {
      isVisible: true,
    };
  },
  methods: {
    close() {
      this.isVisible = false;
    },
  },
};
</script>

<template>
  <div class="modal-backdrop" v-show="isVisible">
    <div class="modal">
      <header class="modal-header">
        <slot name="header"> Philly Restaurant News! </slot>
      </header>
      <section class="modal-body">
        <a
          href="https://philly.eater.com/2020/5/18/21262156/philadelphia-restaurants-bars-closed-permanently-coronavirus-covid-19"
        >
        Restaurants and Bars Closed due to Covid-19
        </a>
        <a href="https://philly.eater.com/maps/20-philly-restaurants-heated-patios-winter">
        20 Philly Restaurants With Top-Notch Heated Patios for the Winter
        </a>
      </section>
      <footer class="modal-footer">
        <slot name="footer">
          Close

          <button type="button" class="btn-green" @click="close">
            X
          </button>
        </slot>
      </footer>
    </div>
  </div>
</template>

<style>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  background: #ffffff;
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
}

.modal-header,
.modal-footer {
  padding: 15px;
  display: flex;
}

.modal-header {
  border-bottom: 1px solid #eeeeee;
  color: #4aae9b;
  justify-content: space-between;
}

.modal-footer {
  border-top: 1px solid #eeeeee;
  justify-content: flex-end;
}

.modal-body {
  position: relative;
  padding: 20px 10px;
}

.btn-close {
  border: none;
  font-size: 20px;
  padding: 20px;
  cursor: pointer;
  font-weight: bold;
  color: #4aae9b;
  background: transparent;
}

.btn-green {
  color: white;
  background: #4aae9b;
  border: 1px solid #4aae9b;
  border-radius: 2px;
}
</style>