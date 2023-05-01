import { ThemeButtonVue } from '@/common/primary/theme-button';
import { shallowMount } from '@vue/test-utils';
import { describe, expect, it } from 'vitest';

describe('ThemeButton', () => {
  it('Should exist', () => {
    const wrapper = shallowMount(ThemeButtonVue);

    expect(wrapper.exists()).toBe(true);
  });

  it('Should switch theme', () => {
    const wrapper = shallowMount(ThemeButtonVue);

    const checkbox = wrapper.find('.container_toggle');

    checkbox.trigger('change');
    expect(wrapper.vm.theme).toEqual('dark-theme');

    checkbox.trigger('change');
    expect(wrapper.vm.theme).toEqual('light-theme');
  });
});
